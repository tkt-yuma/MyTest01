package com.example.demo.controller;

import java.util.List;

import jakarta.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Personlist;
import com.example.demo.repository.PersonlistMapper;

@Controller
public class PersonlistController extends HttpServlet{

	@Autowired
	PersonlistMapper personlist;
	
	//メイン画面
	@GetMapping("mainmenu")
	public String main() {
		return "mainmenu";
	}
	
	//一覧表示画面
	@GetMapping("index")
	public String showindex(Model model) {
		List<Personlist> list = personlist.selectAll();
		model.addAttribute("personlist",list);
		return "index";
	}
	//一覧表示画面
	@PostMapping(value="index",params="index")
	public String showindex2(Model model) {
		List<Personlist> list = personlist.selectAll();
		model.addAttribute("personlist",list);
		return "index";
	}
	
	//新しい人物を登録するダミー
//	@GetMapping("/create")
//	public String createPerson(Model model) {
//		Scanner sc = new Scanner(System.in);
//		
////		System.out.println("aa");
//		//登録用ダミーデータ
////		Personlist john = new Personlist(3,"John",25,"釣り");
//		Personlist person = new Personlist();
//		System.out.print("IDを入力:");
//		person.setId(Integer.parseInt(sc.nextLine()));
//		System.out.print("名前を入力:");
//		person.setName(sc.nextLine());
//		System.out.print("年齢を入力:");
//		person.setAge(Integer.parseInt(sc.nextLine()));
//		System.out.print("趣味を入力:");
//		person.setHobby(sc.nextLine());
//		personlist.insertPerson(person);
////		System.out.println("aaaaaaaaaaaaa");
//		model.addAttribute("message","登録成功");
//		return "success";
//	}
//	
	//Web上のフォームから新規人物を登録する
	@GetMapping("/create")
	public String createPersonForm() {
		return "createPerson";
	}
	
	 // 新しい人物を登録する
    @PostMapping("/create")
    public String createPerson(Personlist person, Model model) {
        // 受け取ったデータをデータベースに保存
        personlist.insertPerson(person);

        model.addAttribute("message", "登録成功");
        return "success"; // 登録成功のページに遷移
    }
    
	//特定のIDを持つ人物の情報を更新する
	@GetMapping("/update/{id}")
	public String updateBook(@PathVariable int id,Model model) {
		//更新用ダミーデータ
		System.out.println("aaaaa");
		Personlist bob = new Personlist();
		personlist.updatePerson(bob);
		model.addAttribute("message","更新成功");
		return "success";
	}
	 
	
	//特定のIDを持つ人物を削除する
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id,Model model) {
		personlist.deletePerson(id);
		model.addAttribute("message","削除成功");
		return "success";
		
	}
	
}
