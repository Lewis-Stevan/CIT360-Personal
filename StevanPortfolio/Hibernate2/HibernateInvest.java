// HibernateInvest.java example

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@Entity
@Table(name = "stock", catalog = "stockdb", uniqueConstraints = { @UniqueConstraint(columnNames = "STOCK_NAME"),
		@UniqueConstraint(columnNames = "STOCK_CODE") })
public class HibernateInvest implements java.io.Serializable {

	private Integer stockId;
	private String stockCode;
	private String stockName;
	private Set<HibernateDesc> categories = new HashSet<HibernateDesc>(0);

	public HibernateInvest() {
	}

	public HibernateInvest(String stockCode, String stockName) {
		this.stockCode = stockCode;
		this.stockName = stockName;
	}

	public HibernateInvest(String stockCode, String stockName, Set<HibernateDesc> categories) {
		this.stockCode = stockCode;
		this.stockName = stockName;
		this.categories = categories;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "STOCK_ID", unique = true, nullable = false)
	public Integer getStockId() {
		return this.stockId;
	}

	public void setStockId(Integer stockId) {
		this.stockId = stockId;
	}

	@Column(name = "STOCK_CODE", unique = true, nullable = false, length = 10)
	public String getStockCode() {
		return this.stockCode;
	}

	public void setStockCode(String stockCode) {
		this.stockCode = stockCode;
	}

	@Column(name = "STOCK_NAME", unique = true, nullable = false, length = 20)
	public String getStockName() {
		return this.stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "stock_category", catalog = "stockdb", joinColumns = {
			@JoinColumn(name = "STOCK_ID", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "CATEGORY_ID", nullable = false, updatable = false) })
	public Set<HibernateDesc> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<HibernateDesc> categories) {
		this.categories = categories;
	}

}