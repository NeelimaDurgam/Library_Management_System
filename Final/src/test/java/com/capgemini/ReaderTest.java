package com.capgemini;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.capgemini.lms.entities.Reader;
import com.capgemini.lms.exception.ReaderNotFoundException;
import com.capgemini.lms.exception.ValidateReaderException;
import com.capgemini.lms.service.ReaderService;

public class ReaderTest extends FinalApplicationTests{
		@Autowired
		ReaderService rs;
		
		@Test
		public void testregister() throws ReaderNotFoundException, ValidateReaderException{
			 Reader reader =new Reader(12,"Neelima0399*","neelima","durgam","9989151461","neelimadurgam479@gmail.com");
			 reader = rs.register(reader);
			 assertEquals(reader.getFirstName(),"neelima");
		}
		
		@Test
		public void testdeleteReader() throws ReaderNotFoundException, ValidateReaderException{
			//Reader np = new Reader(15,"neelima0399","neelima","durgam","9989151461","neelimadurgam479@gmail.com");
			//np  = rs.register(np);
			//assertEquals(15, rs.deleteReader(np.getId()));
			int id = rs.deleteReader(43);
			assertEquals(id, 43);
				
		}
		
		@Test
		public void testviewReadersList() {
			List<Reader> reader = rs.viewReadersList();
			assertThat(reader).size().isGreaterThan(0);
		}
		
		
		
		@Test
		public void testupdateReaderDetails() throws ReaderNotFoundException, ValidateReaderException{
			Reader reader = new Reader(12,"Abgh89@*","neelima","durgam","9989151461","neelimadurgam479@gmail.com");
			reader = rs.updateReaderDetails(reader);
			assertEquals(reader.getFirstName(),"neelima");
		}
		

		@Test
		public void testviewReaderById() throws ReaderNotFoundException, ValidateReaderException {
			Reader read = new Reader(13,"Abgh89@*","neelima","durgam","9989151461","neelimadurgam479@gmail.com");
			read = rs.register(read);
			assertEquals(read.getId(),13);
		}
		
		@Test
		public void testloginValidate() throws ReaderNotFoundException, ValidateReaderException{
			Reader reader = new Reader(20, "Priya@123", "Priya", "shetty","5637256891","priya.s@gmail.com");
			reader = rs.register(reader);
			assertEquals(reader.getEmail(),"priya.s@gmail.com");
			assertEquals(reader.getPassword(),"Priya@123");
		}
			
	}

	
