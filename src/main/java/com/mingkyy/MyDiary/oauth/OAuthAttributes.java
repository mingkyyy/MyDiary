package com.mingkyy.MyDiary.oauth;

import com.mingkyy.MyDiary.domain.Member;
import com.mingkyy.MyDiary.domain.MemberType;
import com.mingkyy.MyDiary.domain.OAuthType;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String name;
    private String oAuthType;
    private String nickname;
    private String email;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey
                          ,String name, String nickname ,String email, String oAuthType) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.oAuthType = oAuthType;
    }

    public static OAuthAttributes of(String registeredId, String userNameAttributeName, Map<String, Object> attributes) {
        if ("naver".equals(registeredId)) {
            return ofNaver("id", attributes);
        }

        if ("kakao".equals(registeredId)) {
            return ofKAKAO("id", attributes);
        }

        return ofGoogle(userNameAttributeName, attributes);
    }

    private static OAuthAttributes ofGoogle(String usernameAttributeName, Map<String, Object> attributes ){
        return OAuthAttributes.builder()
                .name((String)attributes.get("name"))
                .email((String)attributes.get("email"))
                .nickname((String)attributes.get("name"))
                .attributes(attributes)
                .oAuthType("GOOGLE")
                .nameAttributeKey(usernameAttributeName)
                .build();
    }

    private static OAuthAttributes ofNaver(String usernameAttributeName, Map<String, Object> attributes ){
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuthAttributes.builder()
                .name((String) response.get("name"))
                .email((String) response.get("email"))
                .nickname((String) response.get("nickname"))
                .attributes(response)
                .oAuthType("NAVER")
                .nameAttributeKey(usernameAttributeName)
                .build();
    }

    private static OAuthAttributes ofKAKAO(String usernameAttributeName, Map<String, Object> attributes ){
        Map<String, Object> kakaoAccount = (Map<String, Object>)attributes.get("kakao_account");
        Map<String, Object> kakaoProfile = (Map<String, Object>)kakaoAccount.get("profile");

        return OAuthAttributes.builder()
                .email((String) kakaoAccount.get("email"))
                .name((String) kakaoProfile.get("nickname"))
                .nickname((String) kakaoProfile.get("nickname"))
                .attributes(attributes)
                .oAuthType("KAKAO")
                .nameAttributeKey(usernameAttributeName)
                .build();
    }



    public Member toMember(){
        return Member.builder()
                .email(email)
                .oAuthType(OAuthType.valueOf(oAuthType))
                .nickname(nickname)
                .memberType(MemberType.GENERAL)
                .name(name)
                .build();
    }

}
