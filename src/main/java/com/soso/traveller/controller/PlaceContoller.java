package com.soso.traveller.controller;

import com.soso.traveller.entity.Place;
import com.soso.traveller.entity.request.AddPlaceRequest;
import com.soso.traveller.entity.response.ResponseModel;
import com.soso.traveller.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.List;

@RestController
public class PlaceContoller {
    private PlaceRepository placeRepository;

    @Autowired
    public PlaceContoller(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    @RequestMapping(value = "/places",method = RequestMethod.GET)
    public List<Place> findAllPlaces(){
        return  placeRepository.findAll();
    }

    @RequestMapping(value = "/addplace",method = RequestMethod.POST)
    public ResponseModel addPlace(@RequestBody AddPlaceRequest addPlaceRequest){
        Place place=new Place();
        place.setTitle(addPlaceRequest.getTitle());
       // byte[] decodedString= Base64.getDecoder().decode(addPlaceRequest.getImage());
        place.setImage(addPlaceRequest.getImage());
        place.setDate(addPlaceRequest.getDate());
        place.setText(addPlaceRequest.getText());
        place.setAuthorName(addPlaceRequest.getAuthorName());
        place.setAuthorId(addPlaceRequest.getAuthorId());

        placeRepository.save(place);

        ResponseModel responseModel =new ResponseModel(1);

        return responseModel;
    }
}
