package mum.waa.model;

import java.io.Serializable;

public class Name implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String first;
	private String last;
	private boolean editable;

	
	public Name(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public void setFirst(String newValue) {
		first = newValue;
	}

	public String getFirst() {
		return first;
	}

	public void setLast(String newValue) {
		last = newValue;
	}

	public String getLast() {
		return last;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((first == null) ? 0 : first.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		if (first == null) {
			if (other.first != null)
				return false;
		} else if (!first.equals(other.first))
			return false;
		return true;
	}

}
