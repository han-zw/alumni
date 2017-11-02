/**
 * harvey studio.
 * Copyright (c) 2016-2016 All Rights Reserved.
 */
package com.harvey.studio.alumni.web.utils;

import java.security.Key;
import java.text.ParseException;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.harvey.studio.alumni.common.consts.Consts;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * JWT操作工具类.
 * @title JWTUtils
 * @description JWT操作工具类. 
 * @author zw.han
 * @date 2017年4月24日
 * @version 1.0
 */
public class JWTUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(JWTUtils.class);

    private JWTUtils() {
    }

    /**
     * 从header中提取jwt字符串.
     * @param request
     * @return
     */
    public static String fetchJWT(HttpServletRequest request) {
        String auth = request.getHeader(Consts.HEADER_AUTHORIZATION);
        if (StringUtils.isEmpty(auth)) {
            return null;
        }

        if (!auth.startsWith(Consts.TOKEN_BEARER + Consts.SPACE)) {
            return null;
        }

        return auth.split(Consts.SPACE)[1];
    }

    /**
     * 解析jwt
     * @param jsonWebToken jwt密文字符串
     * @param base64Secret  base63编码之后的secret
     * @return
     */
    public static Claims parseJWT(String jsonWebToken, String base64Secret) {
        try {
            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(base64Secret))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            LOGGER.error("parse jwt exception", ex);
            return null;
        }
    }

    /**
     * 获取claims
     * @param request
     * @param secret
     * @return
     */
    public static Claims fetchClaims(HttpServletRequest request, String secret) {
        String jwt = fetchJWT(request);
        if (StringUtils.isEmpty(jwt)) {
            return null;
        }

        // 解析jwt
        Claims claims = JWTUtils.parseJWT(jwt, Base64.encodeBase64String(secret.getBytes()));
        LOGGER.debug("claims info:{}", claims);

        // 非法jwt
        if (claims == null) {
            return null;
        }
        return claims;
    }

    /**
     * 生成JWT
     * @param name
     * @param TTLMillis
     * @param base64Security
     * @return
     * @throws ParseException 
     */
    public static String createJWT(String name, String base64Security) throws ParseException {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //生成签名密钥  
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Security);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //添加构成JWT的参数  
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT").setHeaderParam("alg", "HS256")
                .claim("user", name).setIssuer("ucarinc").setSubject("ucarinc-onedata")
                .signWith(signatureAlgorithm, signingKey);

        //添加Token过期时间 , 暂时设置为2099年
        Date exp = DateUtils.parseDate("20991231235959", "yyyyMMddHHmmss");
        builder.setExpiration(exp);

        //生成JWT  
        return builder.compact();
    }
}
