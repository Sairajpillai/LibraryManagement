package in.ineuron.service;

import in.ineuron.dto.Librarian;

public interface ILibrarianService {
	
	public String verifyLibrerian(int id,String password);

	public String saveLibrarian(Librarian librarian);

	public Librarian getLiberarian(int id);

	public String updateLibrarian(Librarian librarian);

	public String deleteLibrarian(int id);

}
