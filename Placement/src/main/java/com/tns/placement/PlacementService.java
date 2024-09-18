package com.tns.placement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlacementService {
    @Autowired
    private PlacementRepository placementRepository;

    public List<Placement> getAllPlacements() {
        return placementRepository.findAll();
    }

    public Placement getPlacementById(Long id) {
        return placementRepository.findById(id).orElseThrow(() -> new RuntimeException("Placement not found"));
    }

    public Placement savePlacement(Placement placement) {
        return placementRepository.save(placement);
    }

    public void deletePlacement(Long id) {
        placementRepository.deleteById(id);
    }
}


