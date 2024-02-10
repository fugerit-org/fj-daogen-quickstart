package org.fugerit.java.fjdaogenquickstart;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ContextLoadTest {

	@Autowired
	private LoadDocument loadDocument;

	@Autowired
	private LoadExample01 loadExample01;

	@Autowired
	private LoadMappedTable loadMappedTable;

	@Autowired
	private LoadPerson loadPerson;

	@Test
	void contextLoads() {
		assertThat( this.loadDocument ).isNotNull();
		assertThat( this.loadExample01 ).isNotNull();
		assertThat( this.loadMappedTable ).isNotNull();
		assertThat( this.loadPerson ).isNotNull();
	}

	public static void main(String[] args) {
		SpringApplication.run(FjDaogenQuickstartApplication.class, args);
	}

}
