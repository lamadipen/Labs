package mum.waa.repositoryImpl;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import mum.waa.model.Name;
import mum.waa.repository.NameRepository;

public class NameRepositoryImpl implements NameRepository,Serializable{
	
	private static Name[] names = new Name[] { new Name("William", "Dupont"), new Name("Anna", "Keeney"),
			new Name("Mariko", "Randor"), new Name("John", "Wilson"), new Name("Dipen", "Lama"),
			new Name("Jai", "Limbu"), new Name("Sanjay", "Shrestha") };
	
	@Override
	public boolean createName(Name name) {
		
		Name[] temp ={name};
		
		Stream namesStream  = (Stream) Arrays.stream(names);
		Stream tempStream = (Stream) Arrays.stream(temp);
		
		List<Name> tmpList = (List<Name>) Stream.concat(namesStream,tempStream).collect(Collectors.toList());
		
		names = tmpList.toArray(new Name[tmpList.size()]);
		
		return true;
	}

	@Override
	public boolean deleteName(Name nameToDelete) {
		// TODO Auto-generated method stub
		Name[] tempArrName = null;
		
		/*	before java 8
		 for (int i = 0; i < names.length; i++) {
				Name tempName = names[i];
				if(nameToDelete.getFirst().equals(tempName.getFirst()))
				{
					  
				}
				else
				{
					tempArrName[i] = tempName;
				}
			}*/
			
			//lambda expression
			tempArrName = Arrays.stream(names).filter(n->!n.getFirst().equalsIgnoreCase(nameToDelete.getFirst())).toArray(Name[]::new);
					names = tempArrName;
		
		return false;
	}

	@Override
	public Name[] getAllNames() {
		// TODO Auto-generated method stub
		return names;
	}

	@Override
	public Name getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
