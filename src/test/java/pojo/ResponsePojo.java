package pojo;

import java.io.Serializable;
import java.util.List;

public class ResponsePojo implements Serializable {
	private int page;
	private int perPage;
	private int total;
	private int totalPages;
	private List<DataPojo> data;
	private SupportPojo support;

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setPerPage(int perPage){
		this.perPage = perPage;
	}

	public int getPerPage(){
		return perPage;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setData(List<DataPojo> data){
		this.data = data;
	}

	public List<DataPojo> getData(){
		return data;
	}

	public void setSupport(SupportPojo support){
		this.support = support;
	}

	public SupportPojo getSupport(){
		return support;
	}

	@Override
 	public String toString(){
		return 
			"ResponsePojo{" + 
			"page = '" + page + '\'' + 
			",per_page = '" + perPage + '\'' + 
			",total = '" + total + '\'' + 
			",total_pages = '" + totalPages + '\'' + 
			",data = '" + data + '\'' + 
			",support = '" + support + '\'' + 
			"}";
		}
}