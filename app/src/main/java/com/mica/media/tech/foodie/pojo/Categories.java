package com.mica.media.tech.foodie.pojo;

public class Categories{
	private String typeName;
	private String typeId;
	private String typeDescription;

	public void setTypeName(String typeName){
		this.typeName = typeName;
	}

	public String getTypeName(){
		return typeName;
	}

	public void setTypeId(String typeId){
		this.typeId = typeId;
	}

	public String getTypeId(){
		return typeId;
	}

	public void setTypeDescription(String typeDescription){
		this.typeDescription = typeDescription;
	}

	public String getTypeDescription(){
		return typeDescription;
	}

	@Override
 	public String toString(){
		return 
			"Categories{" + 
			"type_name = '" + typeName + '\'' + 
			",type_id = '" + typeId + '\'' + 
			",type_description = '" + typeDescription + '\'' + 
			"}";
		}
}
