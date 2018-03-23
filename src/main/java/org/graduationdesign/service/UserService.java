package org.graduationdesign.service;

import org.graduationdesign.util.UnifiedResponse;

public interface UserService {
   Integer registerVerification(String email) throws Exception;
   Integer simpleRegister(String email,String verificationCode) throws Exception;
   Boolean userIfExits(String email) throws Exception;
}
