package com.df.drs.base.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.df.drs.model.entity.FamilyHistory;

import java.util.Date;

public class JWTUtils {

    public static String getToken(FamilyHistory user) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + (1000 * 60 * 60 * 24));

        String token = "";
        token = JWT.create().withAudience(user.getId() + "")
                .withIssuedAt(nowDate).withExpiresAt(expireDate)
                .sign(Algorithm.HMAC256(user.getId()));
        return token;
    }

}