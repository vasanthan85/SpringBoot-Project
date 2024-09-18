package com.tns.placement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/placements")
public class PlacementController {
    @Autowired
    private PlacementService placementService;

    @GetMapping("/Placement")
    public List<Placement> getAllPlacements() {
        return placementService.getAllPlacements();
    }

    @GetMapping("/Placement/{id}")
    public ResponseEntity<Placement> getPlacementById(@PathVariable Long id) {
        return ResponseEntity.ok(placementService.getPlacementById(id));
    }

    @PostMapping("/Placement")
    public ResponseEntity<Placement> createPlacement(@RequestBody Placement placement) {
        return ResponseEntity.status(HttpStatus.CREATED).body(placementService.savePlacement(placement));
    }

    @DeleteMapping("/Placement/{id}")
    public ResponseEntity<Void> deletePlacement(@PathVariable Long id) {
        placementService.deletePlacement(id);
        return ResponseEntity.noContent().build();
    }
}


