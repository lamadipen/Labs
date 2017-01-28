package mum.waa.serviceImpl;

import java.io.Serializable;

import javax.inject.Inject;

import mum.waa.model.Name;
import mum.waa.repository.NameRepository;
import mum.waa.service.NameService;

public class NameServiceImpl implements NameService,Serializable {

	@Inject
	NameRepository nameRepository;
	
	@Override
	public boolean createName(Name name) {
		// TODO Auto-generated method stub
		return nameRepository.createName(name);
	}

	@Override
	public boolean deleteName(Name nameToDelete) {
		// TODO Auto-generated method stub
		return nameRepository.deleteName(nameToDelete);
	}

	@Override
	public Name[] getAllNames() {
		// TODO Auto-generated method stub
		return nameRepository.getAllNames();
	}

	@Override
	public Name getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
