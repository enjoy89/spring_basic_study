package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // JPA가 관리하는 앤티티라는 의미. 자바 객체와 DB와 매핑된다.
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // db가 알아서 자동으로 id를 생성해줌
    private Long id; // id를 pk로 설정
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
