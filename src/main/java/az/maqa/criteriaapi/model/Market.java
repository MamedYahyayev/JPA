package az.maqa.criteriaapi.model;

import javax.persistence.Entity;

import az.maqa.mappedsuperclass.model.BaseEntity;

@Entity
public class Market extends BaseEntity {

	private String marketName;

	private String location;

	private double areaSize;

	private double sellPrice;

	public Market() {

	}

	public Market(String marketName, String location, double areaSize, double sellPrice) {
		this.marketName = marketName;
		this.location = location;
		this.areaSize = areaSize;
		this.sellPrice = sellPrice;
	}

	public String getMarketName() {
		return marketName;
	}

	public String getLocation() {
		return location;
	}

	public double getAreaSize() {
		return areaSize;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setMarketName(String marketName) {
		this.marketName = marketName;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setAreaSize(double areaSize) {
		this.areaSize = areaSize;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	@Override
	public String toString() {
		return "Market [marketName=" + marketName + ", location=" + location + ", areaSize=" + areaSize + ", sellPrice="
				+ sellPrice + ", getId()=" + getId() + "]";
	}

	
	
}
