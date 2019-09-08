package com.pkd.bean;

public class QnAPatternBean {

String type;
QnAPatterenChildBean patteren;
String typeCode;
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public QnAPatterenChildBean getPatteren() {
	return patteren;
}
public void setPatteren(QnAPatterenChildBean patteren) {
	this.patteren = patteren;
}
public String getTypeCode() {
	return typeCode;
}
public void setTypeCode(String typeCode) {
	this.typeCode = typeCode;
}
@Override
public String toString() {
	return "QnAPatternBean [type=" + type + ", patteren=" + patteren + ", typeCode=" + typeCode + "]";
}

	
}
