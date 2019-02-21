package com.mb11.application.payload.admin.sport.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mb11.application.controller.cricapidata.SeriesNotFoundException;
import com.mb11.application.dao.cricapidata.SeriesRepository;
import com.mb11.application.model.cricapidata.Series;


@Service
public class SeriesService {
	
	@Autowired
	private SeriesRepository sr;
	
	@Autowired
	private com.mb11.application.payload.admin.sport.Series adminSeries;
	
	public List<com.mb11.application.payload.admin.sport.Series> getAllSeries()
	{
		List<Series> st=sr.findAll();
		List<com.mb11.application.payload.admin.sport.Series> asl=new ArrayList<>();
		
		
		
		for(Series s:st)
		{
			adminSeries.setObjId(s.getID());
			adminSeries.setDisplayName(s.getSname());
			adminSeries.setSeriesId(s.getSeriesid());
			adminSeries.setStartdate(s.getStartdate());
			adminSeries.setEnddate(s.getEnddate());
			adminSeries.setTotalmatch(s.getTotalmatch());
			adminSeries.setLink("");
			adminSeries.setTeamlistLink("");
			adminSeries.setMatchlistLink("");
			
			asl.add(adminSeries);
		}
		
		
		return asl;
	}
	
	public com.mb11.application.payload.admin.sport.Series getSeriesBySeriesID(String id)
	{
        Series s = sr.findBySeriesid(id);
		
		if(s==null)
			throw new SeriesNotFoundException("id-"+ id);
		
	
			adminSeries.setObjId(s.getID());
			adminSeries.setDisplayName(s.getSname());
			adminSeries.setSeriesId(s.getSeriesid());
			adminSeries.setStartdate(s.getStartdate());
			adminSeries.setEnddate(s.getEnddate());
			adminSeries.setTotalmatch(s.getTotalmatch());
			adminSeries.setLink("");
			adminSeries.setTeamlistLink("");
			adminSeries.setMatchlistLink("");
			
			return adminSeries;
	}
	
	
	public List<com.mb11.application.payload.admin.sport.Series> getSeriesByStartAndEndDate(Date startDate,Date endDate)
	{
        List<Series> st = sr.findByDates(startDate, endDate);
List<com.mb11.application.payload.admin.sport.Series> asl=new ArrayList<>();
				
		for(Series s:st)
		{
			adminSeries.setObjId(s.getID());
			adminSeries.setDisplayName(s.getSname());
			adminSeries.setSeriesId(s.getSeriesid());
			adminSeries.setStartdate(s.getStartdate());
			adminSeries.setEnddate(s.getEnddate());
			adminSeries.setTotalmatch(s.getTotalmatch());
			adminSeries.setLink("");
			adminSeries.setTeamlistLink("");
			adminSeries.setMatchlistLink("");
			
			asl.add(adminSeries);
		}
		
		
		return asl;
		
			
	}


}
