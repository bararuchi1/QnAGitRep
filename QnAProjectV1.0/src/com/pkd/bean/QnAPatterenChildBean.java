package com.pkd.bean;

public class QnAPatterenChildBean {
String multipleAnswer;
String numberOfAnswer;
String wordCount;
public String getMultipleAnswer() {
	return multipleAnswer;
}
public void setMultipleAnswer(String multipleAnswer) {
	this.multipleAnswer = multipleAnswer;
}
public String getNumberOfAnswer() {
	return numberOfAnswer;
}
public void setNumberOfAnswer(String numberOfAnswer) {
	this.numberOfAnswer = numberOfAnswer;
}
public String getWordCount() {
	return wordCount;
}
public void setWordCount(String wordCount) {
	this.wordCount = wordCount;
}
@Override
public String toString() {
	return "QnAPatterenChildBean [multipleAnswer=" + multipleAnswer + ", numberOfAnswer=" + numberOfAnswer
			+ ", wordCount=" + wordCount + "]";
}

}
