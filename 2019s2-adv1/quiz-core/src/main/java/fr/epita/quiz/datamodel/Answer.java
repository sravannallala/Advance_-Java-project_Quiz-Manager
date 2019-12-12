package fr.epita.quiz.datamodel;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author sravannallala
 * Pojo class for Answers
 */	
@Entity
@Table(name="ANSWER")
public class Answer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	private Integer id;
	
	@Column(name="QID")
	private Integer qid;
	
	
	@Column(name="ANSWER")
	private String answer;
	
	@Column(name="OP1")
	private String op1;
	
	@Column(name="OP2")
	private String op2;

	@Column(name="OP3")
	private String op3;
	
	@Column(name="OP4")
	private String op4;
	
	public Answer() {

	}

	public Answer(String answer) {
		this.answer = answer;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQid() {
		return qid;
	}

	public void setQid(Integer qid) {
		this.qid = qid;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getOp1() {
		return op1;
	}

	public void setOp1(String op1) {
		this.op1 = op1;
	}

	public String getOp2() {
		return op2;
	}

	public void setOp2(String op2) {
		this.op2 = op2;
	}

	public String getOp3() {
		return op3;
	}

	public void setOp3(String op3) {
		this.op3 = op3;
	}

	public String getOp4() {
		return op4;
	}

	public void setOp4(String op4) {
		this.op4 = op4;
	}


	
	
	

}
