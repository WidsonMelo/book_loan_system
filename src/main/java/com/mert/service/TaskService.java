package com.mert.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mert.model.Task;
import com.mert.repository.TaskRepository;

@Service
@Transactional
public class TaskService {

	private final TaskRepository taskRepository;
	

	public TaskService(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	public List<Task> findAll(){
		List<Task> tasks = new ArrayList<>();
		tasks = taskRepository.findAll();
		return tasks;
	}
	
	public List<Task> findByUserId(int userid){
		List<Task> tasks = this.findAll();
		
		List<Task> taskFinal = new ArrayList<>();
		
		for (Task task : tasks) {
			if(task.getUserid() == userid) {
				taskFinal.add(task);
			}
		}
		
		return taskFinal;
	}
	
	public List<Task> findByTaskEmprestado(int userid){
		List<Task> tasks = this.findAll();
		
		List<Task> taskFinal = new ArrayList<>();
		
		for (Task task : tasks) {
			System.out.println("===================222222" + userid);
			if((task.getEmprestado().equals("Não")) && (task.getUserid() == userid)) {
				taskFinal.add(task);
				System.out.println("===================" + task.getEmprestado());
			}
		}
		
		return taskFinal;
	}
	
	public Task findTask(int id){
		return taskRepository.findOne(id);
	}
	
	public void save(Task task){
		taskRepository.save(task);
	}
	
	public void delete(int id){
		taskRepository.delete(id);

	}
}
