package pe.edu.calificame.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import model.University;
import pe.edu.calificame.dto.DtoUniversity;

@Named
@SessionScoped
public class BeanUniversity implements Serializable{
	private List<DtoUniversity> listUniversity;

	private String test;
	
	public BeanUniversity (){
		test="testing dude";
		System.out.println("construct");
		
	}
	
	@PostConstruct
	public void initialize() {
		listUniversity = new ArrayList();
		DtoUniversity uni = new DtoUniversity();
		uni.setCname("UTP");
		listUniversity.add(uni);
		uni = new DtoUniversity();
		uni.setCname("UCSP");
		listUniversity.add(uni);
		uni = new DtoUniversity();
		uni.setCname("UNSA");
		listUniversity.add(uni);
		System.out.println("INICIO LISTA");
		for (DtoUniversity dtoUniversity : listUniversity) {
			System.out.println(dtoUniversity .getCname());
		}
		System.out.println("FIN LISTA");
	}
	
	public List<DtoUniversity> getListUniversity() {
		
		return listUniversity;
	}

	public void setListUniversity(List<DtoUniversity> listUniversity) {
		this.listUniversity = listUniversity;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}
	
	
}
