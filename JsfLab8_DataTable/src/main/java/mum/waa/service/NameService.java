package mum.waa.service;

import mum.waa.model.Name;

public interface NameService {
	public boolean createName(Name name);
	public boolean deleteName(Name nameToDelete);
	public Name[] getAllNames();
	public Name getName();
}
