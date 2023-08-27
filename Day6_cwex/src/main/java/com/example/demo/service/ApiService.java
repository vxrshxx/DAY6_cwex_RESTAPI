package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Child;
import com.example.demo.repository.ChildRepo;


@Service
public class ApiService {

@Autowired
ChildRepo cr;

    public Child saveinfo(Child cc)
    {
    return cr.save(cc);//saving the data from repository into the database
    }
   
    public List<Child> savedetails(List<Child> cc)
    {
    return (List<Child>) cr.saveAll(cc);
    }
    public List<Child> showinfo()
    {
    return cr.findAll();// retrieving the data that has been store in the database
    }
    public Optional<Child> showbyid(int id)
    {
    return cr.findById(id);
    }
    public Child changeinfo(Child cc)
    {
    return cr.saveAndFlush(cc);
    }
    public void deleteinfo(Child cc)
    {
    cr.delete(cc);
    }
    //delete by id for path variable
    public void deleteid(int id)
    {
    cr.deleteById(id);
    }
   
    //delete by id for requestParam
    public void deletepid(int id)
    {
    cr.deleteById(id);
    }
    public List<Child> sortinfo(String s)
    {
    return cr.findAll(Sort.by(Sort.Direction.DESC,s));
    }
    public List<Child> getbypage(int pgno,int pgsize)
    {
    Page<Child> p=cr.findAll(PageRequest.of(pgno, pgsize));
    return p.getContent();
    }
   
    public String updateinfobyid(int id,Child cc)
    {
    cr.saveAndFlush(cc);
    if(cr.existsById(id))
    {
    return "Updated";
    }
    else
    {
    return "Enter valid id";
    }
    }
}
