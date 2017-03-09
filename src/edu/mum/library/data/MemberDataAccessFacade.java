package edu.mum.library.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import edu.mum.library.business.LibraryMember;

public class MemberDataAccessFacade implements MemberDataAccess {
	public static final String OUTPUT_DIR = System.getProperty("user.dir") 
			+ "\\src\\edu\\mum\\library\\data\\storage\\members";
	public static final String DATE_PATTERN = "MM/dd/yyyy";
	
	@Override
	public void saveLibraryMember(int memberNumber, LibraryMember member) {
		ObjectOutputStream out = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR,Integer.toString(memberNumber));
			out = new ObjectOutputStream(Files.newOutputStream(path));
			out.writeObject(member);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch(Exception e) {}
			}
		}
	}

	@Override
	public LibraryMember readLibraryMember(int memberNumber) {
		ObjectInputStream in = null;
		LibraryMember member = null;
		try {
			Path path = FileSystems.getDefault().getPath(OUTPUT_DIR,Integer.toString(memberNumber));
			in = new ObjectInputStream(Files.newInputStream(path));
			member = (LibraryMember)in.readObject();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(in != null) {
				try {
					in.close();
				} catch(Exception e) {}
			}
		}
		return member;
	}

}
