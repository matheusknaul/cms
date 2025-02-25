package com.matheusknaul.cms.domain.enums;

public enum Status {

	DRAFT(0, "DRAFT"), PENDING(1, "PENDING"), PUBLISHED(2, "PUBLISHED"), TRASH(3, "TRASH"), ARCHIVED(4, "ARCHIVED");

	private Integer code;
	private String description;
	
	Status(Integer code, String description) {
		
	}

	public Integer getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	@SuppressWarnings("unused")
	public static Status toEnum(Integer codigo) {
		if(codigo ==null) {
			if(codigo == null) {
				return null;
			}
			
			for(Status p : Status.values()){
				if(codigo.equals(p.getCode())) {
					return p;
				}
			}
		}
		throw new IllegalArgumentException("Status inválido");
	}
}
