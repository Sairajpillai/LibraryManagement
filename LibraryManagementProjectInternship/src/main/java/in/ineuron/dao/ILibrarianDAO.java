package in.ineuron.dao;

import in.ineuron.dto.Librarian;

public interface ILibrarianDAO {
	
	public String verifyLibrarian(int id,String password);
	
	public String saveLibrarian(Librarian librarian);
	
	public Librarian getLiberarian(int id);
	
	public String updateLibrarian(Librarian librarian);
	
	public String deleteLibrarian(int id);

}
