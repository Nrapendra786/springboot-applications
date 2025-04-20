package com.techwaala.car_image_analysis;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/image")
public class ImageController {

    private CarCountService carCountService;

    @Autowired
    public ImageController(CarCountService carCountService){
       this.carCountService=carCountService;
    }

    @Operation(summary = "Upload a file and count cars")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Car count processed successfully",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Integer.class)) }),
            @ApiResponse(responseCode = "500", description = "Error uploading file")
    })
    @PostMapping(value="/carCounts", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> carCounts(
            @Parameter(description = "File to be uploaded", required = true) @RequestParam("file") MultipartFile file) {
        String colors = "Red";
        try (InputStream inputStream = file.getInputStream()) {
            var carCount = carCountService.countCar(inputStream, file.getContentType(), colors);
            return ResponseEntity.ok(carCount);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading file");
        }
    }
}
