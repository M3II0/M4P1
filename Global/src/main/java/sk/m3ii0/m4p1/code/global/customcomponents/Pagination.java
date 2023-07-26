package sk.m3ii0.m4p1.code.global.customcomponents;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Pagination<V> {
	
	private final List<V> list;
	private final List<List<V>> pages;
	private final int size;
	
	public Pagination(List<V> list, int size) {
		this.list = list;
		this.size = size;
		this.pages = getPages(list, size);
	}
	
	
	public List<V> getList() {
		return list;
	}
	
	public int getSize() {
		return size;
	}
	
	public List<V> getPage(int page) {
		return pages.get(page);
	}
	
	public int getTotalPages() {
		return pages.size();
	}
	
	private static <T> List<List<T>> getPages(Collection<T> c, Integer pageSize) {
		if (c == null)
			return Collections.emptyList();
		List<T> list = new ArrayList<T>(c);
		if (pageSize == null || pageSize <= 0 || pageSize > list.size())
			pageSize = list.size();
		int numPages = (int) Math.ceil((double)list.size() / (double)pageSize);
		List<List<T>> pages = new ArrayList<List<T>>(numPages);
		for (int pageNum = 0; pageNum < numPages;)
			pages.add(list.subList(pageNum * pageSize, Math.min(++pageNum * pageSize, list.size())));
		return pages;
	}
	
}
