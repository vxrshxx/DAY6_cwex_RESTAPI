package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Child;
import com.example.demo.service.ApiService;



@RestController
public class ApiController {
@Autowired//
ApiService aser;

@PostMapping("addchild")
public Child add(@RequestBody Child cc)
{
return aser.saveinfo(cc);
}

@PostMapping("addnchild")
public List<Child> addndetails(@RequestBody List<Child> cc)
{
return aser.savedetails(cc);
}

   
@GetMapping("showchdetails")
   public List<Child> show()
   {
  return aser.showinfo();
   }
@GetMapping("showchdetbyid/{id}")
public Optional<Child> showid(@PathVariable int id)
{
  return aser.showbyid(id);
}

@PutMapping("updatech")
public Child modify(@RequestBody Child cc)
{
return aser.changeinfo(cc);
}

@PutMapping("updatechbyid/{id}")
public String modifybyid(@PathVariable int id,@RequestBody Child cc)
{
return aser.updateinfobyid(id, cc);
}

@DeleteMapping("deletechdetail")
public String del(@RequestBody Child cc )
{
aser.deleteinfo(cc);
return "Deleted succesfully";
}
@DeleteMapping("delidch/{id}")
public void deletemyid(@PathVariable int id)
{
aser.deleteid(id);

}
@DeleteMapping("delchparamid")
public void deletemyparamid(@RequestParam int id)
{
aser.deletepid(id);

}
@GetMapping("sort/{babyFirstName}")
public List<Child> getsortinfo(@PathVariable String babyFirstName)
{
return aser.sortinfo(babyFirstName);
}
@GetMapping("paging/{pageno}/{pagesize}")
public List<Child> showpageinfo(@PathVariable int pageno,@PathVariable int pagesize)
{
return aser.getbypage(pageno, pagesize);
}

}


