package com.euromisi.infordatainterface.restcontroller;

import com.euromisi.infordatainterface.model.Item;
import com.euromisi.infordatainterface.service.InforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemApiController {

    @Autowired
    InforService inforService;

    @GetMapping(value="/items", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Item>> getItems() {
        try {
            ResponseEntity<List<Item>> responseEntity =
                    new ResponseEntity<List<Item>>(inforService.getItems(), HttpStatus.OK);

            return responseEntity;
        } catch (Exception e) {
            return new ResponseEntity<List<Item>>(HttpStatus.BAD_REQUEST);
        }

    }

    @GetMapping("/item/{itemCode}")
    public ResponseEntity<Item> getItemById(@PathVariable String itemCode) {

            Item item = inforService.getItemById(itemCode);
            //System.out.println(item);
            return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/count/{itemCode}")
    public int countItemById(@PathVariable String itemCode) {

        int num = inforService.countItemById(itemCode);
        //System.out.println(item);
        return num;
    }

    @GetMapping(value="/items/{ptc}", produces = {MimeTypeUtils.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Item>> getItemsByPartialIId(@PathVariable String ptc) {
        try {
            ResponseEntity<List<Item>> responseEntity =
                    new ResponseEntity<List<Item>>(inforService.getItemsByPartialId(ptc), HttpStatus.OK);

            return responseEntity;
        } catch (Exception e) {
            return new ResponseEntity<List<Item>>(HttpStatus.BAD_REQUEST);
        }

    }
}
