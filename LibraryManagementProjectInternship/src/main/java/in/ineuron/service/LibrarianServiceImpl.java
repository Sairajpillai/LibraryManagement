package in.ineuron.service;



import in.ineuron.dao.ILibrarianDAO;
import in.ineuron.daofactory.LibrarianDAOFactory;
import in.ineuron.dto.Librarian;

public class LibrarianServiceImpl implements ILibrarianService {

	ILibrarianDAO libDao = null;

	@Override
	public String saveLibrarian(Librarian librarian) {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		librarian.setDoj(sqlDate);
		librarian.setRole("lib");
		libDao = LibrarianDAOFactory.getLibrerianDAO();
		if (libDao != null) {
			return libDao.saveLibrarian(librarian);
		}
		return "failure";
	}

	@Override
	public Librarian getLiberarian(int id) {
		libDao = LibrarianDAOFactory.getLibrerianDAO();
		return libDao.getLiberarian(id);
	}

	@Override
	public String updateLibrarian(Librarian librarian) {
		libDao = LibrarianDAOFactory.getLibrerianDAO();
		return libDao.updateLibrarian(librarian);
	}

	@Override
	public String deleteLibrarian(int id) {
		libDao = LibrarianDAOFactory.getLibrerianDAO();
		return libDao.deleteLibrarian(id);
	}

	@Override
	public String verifyLibrerian(int id,String password) {
		libDao = LibrarianDAOFactory.getLibrerianDAO();
		return libDao.verifyLibrarian(id,password);
	}

}
