package springbootcdijpa.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_db")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private User() {
	}
	
	public User(String name) {
		this.name = name;
	}

	public Long id() {
		return id;
	}

	public String name() {
		return name;
	}
}
