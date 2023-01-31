package com.mingkyy.MyDiary.oauth;

import com.mingkyy.MyDiary.domain.Member;
import com.mingkyy.MyDiary.repository.MemberRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService implements OAuth2UserService{
    private final MemberRepository memberRepository;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2UserService service = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = service.loadUser(userRequest);

        String registeredId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();
        OAuthAttributes attributes = OAuthAttributes.of(
                registeredId, userNameAttributeName, oAuth2User.getAttributes()
        );

        Member member = saveOrUpdate(attributes);

        return new MemberOAuth2User(member, attributes);
    }


        private Member saveOrUpdate(OAuthAttributes attributes){
            Member member = memberRepository.findByEmail(attributes.getEmail())
                    .map(entity -> entity.update(attributes.getName(), attributes.getEmail()))
                    .orElse(attributes.toMember());
            return memberRepository.save(member);
        }

    }


