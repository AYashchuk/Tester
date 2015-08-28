package domain;

import javax.persistence.*;

@Entity
@Table(name = "QUESTION")
public class Question {


    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "USERS_SEQ", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "ID")
    Long id;

    String text;
    String [] answer;
    String rightAnswer;



}
