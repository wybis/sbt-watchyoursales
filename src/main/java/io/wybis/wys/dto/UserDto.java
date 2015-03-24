package io.wybis.wys.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserDto implements Serializable {

	private String userId;

	private String password;

	private String newPassword;
}
