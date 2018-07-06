package pds;
import java.io.*;
import java.util.*;
public class Order {
	int oId;
	double oAmount;
	String pId;
	String pName;
	String pType;
	String pSize;
	String pBase;
	String pDeliver;
	public String getpDeliver() {
		return pDeliver;
	}
	public void setpDeliver(String pDeliver) {
		this.pDeliver = pDeliver;
	}
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public double getoAmount() {
		return oAmount;
	}
	public void setoAmount(double oAmount) {
		this.oAmount = oAmount;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpType() {
		return pType;
	}
	public void setpType(String pType) {
		this.pType = pType;
	}
	public String getpSize() {
		return pSize;
	}
	public void setpSize(String pSize) {
		this.pSize = pSize;
	}
	public String getpBase() {
		return pBase;
	}
	public void setpBase(String pBase) {
		this.pBase = pBase;
	}
}
