package com.bj;

import java.io.Serializable;
import java.util.List;

public class TraceNode implements Serializable {

	private String uuid;
	private String clazz;
	private String method;
	private long startnano;
	private long endnano;
	private long timecost;
	private int step;
	private TraceNode parent;
	private List<TraceNode> subNodes;
	private String dt;
	private String cluster;

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public String getDt() {
		return dt;
	}

	public void setDt(String dt) {
		this.dt = dt;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getClazz() {
		return clazz;
	}

	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public long getStartnano() {
		return startnano;
	}

	public void setStartnano(long startnano) {
		this.startnano = startnano;
	}

	public long getEndnano() {
		return endnano;
	}

	public void setEndnano(long endnano) {
		this.endnano = endnano;
	}

	public long getTimecost() {
		return timecost;
	}

	public void setTimecost(long timecost) {
		this.timecost = timecost;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public TraceNode getParent() {
		return parent;
	}

	public void setParent(TraceNode parent) {
		this.parent = parent;
	}

	public List<TraceNode> getSubNodes() {
		return subNodes;
	}

	public void setSubNodes(List<TraceNode> subNodes) {
		this.subNodes = subNodes;
	}
}
