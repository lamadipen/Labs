package mum.waa.repository;

import java.util.List;

import mum.waa.model.Name;

public interface NameRepository {
	public boolean deleteName(Name nameToDelete);
	public Name[] getAllNames();
	public Name getName();
	boolean createName(Name name);
}
