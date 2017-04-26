//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.lrb.saas.core.model.qingjing.production;

import com.lrb.saas.core.annotation.SAASField;
import com.lrb.saas.core.model.qingjing.production.ProductionType;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Production{// implements Comparable<Production>
	@Id
	@SAASField(
			name = "主键"
	)
	private String id;
	@SAASField(
			name = "产品名称"
	)
	private String name;
	@SAASField(
			name = "产品子名称"
	)
	private String subName;
	@SAASField(
			name = "显示顺序"
	)
	@NotNull
	private Integer showOrder;
	@SAASField(
			name = "产品种类",
			uiComponent = "Select",
			dictionaryUrl = "http://m.qinjuu.com/cdn/js/dictionary/productionCategory.js"
	)
	@NotEmpty
	private String category;
	@SAASField(
			name = "产品简短描述",
			uiComponent = "textarea"
	)
	private String shotDescrpiton;
	@SAASField(
			name = "产品缩略图地址"
	)
	private String thumbnailUri;
	@SAASField(
			name = "产品金额"
	)
	private String price;
	@OneToMany(
			mappedBy = "production"
	)
	private List<ProductionType> productionTypes;
	@SAASField(
			name = "产品详细描述",
			uiComponent = "textarea"
	)
	private String descrption;
	@SAASField(
			name = "产品承诺"
	)
	private String promise;
	@SAASField(
			name = "销售标签",
			uiComponent = "Select",
			dictionaryUrl = "http://m.qinjuu.com/cdn/js/dictionary/productionTag.js"
	)
	private String tag;

	public Production() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubName() {
		return this.subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public String getShotDescrpiton() {
		return this.shotDescrpiton;
	}

	public void setShotDescrpiton(String shotDescrpiton) {
		this.shotDescrpiton = shotDescrpiton;
	}

	public String getThumbnailUri() {
		return this.thumbnailUri;
	}

	public void setThumbnailUri(String thumbnailUri) {
		this.thumbnailUri = thumbnailUri;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public List<ProductionType> getProductionTypes() {
		return this.productionTypes;
	}

	public void setProductionTypes(List<ProductionType> productionTypes) {
		this.productionTypes = productionTypes;
	}

	public String getDescrption() {
		return this.descrption;
	}

	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}

	public Integer getShowOrder() {
		return this.showOrder;
	}

	public void setShowOrder(Integer showOrder) {
		this.showOrder = showOrder;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPromise() {
		return this.promise;
	}

	public void setPromise(String promise) {
		this.promise = promise;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

//	public int compareTo(Production o) {
//		return this.initShowOrder(this) - this.initShowOrder(o);
//	}

//	private int initShowOrder(Production production) {
//		String var2;
//		switch((var2 = production.getCategory()).hashCode()) {
//			case -1471091812:
//				if(var2.equals("电热坐垫毯")) {
//					return 0 + production.getShowOrder().intValue();
//				}
//				break;
//			case -1391716038:
//				if(var2.equals("书桌加热器毯")) {
//					return -1000 + production.getShowOrder().intValue();
//				}
//				break;
//			case 29758615:
//				if(var2.equals("电热毯")) {
//					return 1000 + production.getShowOrder().intValue();
//				}
//		}
//
//		return 0;
//	}
}
