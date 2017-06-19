package trng.imcs.app.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;
@Service
public class LoginValidation {
	

	public boolean ValidateCredentials(String user, String password,HashMap<String, String> loginMap){
		if(password.equals(loginMap.get(user)))
			return true;
		else
			return false;
	}

}
