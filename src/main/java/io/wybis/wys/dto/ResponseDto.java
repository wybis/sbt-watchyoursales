package io.wybis.wys.dto;

import lombok.Data;

@Data
public class ResponseDto {

	public static final int UNKNOWN = -1;

	public static final int SUCCESS = 0;

	public static final int ERROR = 1;

	private int type;

	private String message;

	private Object data;

}
