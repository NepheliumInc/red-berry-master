# RedBerry-PMS

### tips  :
- when add new menu item to sidebar add it into the
```/sidebar.html```

- CORS filter allowed only to ```redberry.com``` and ```www.redberry.com```
- RESTful Service hostname is set in the ```"/dist/js/app.min.js"``` as a global JS variable (```baseUrl```) every ajax request should have this url prefix

    ex: 
    
    ```
        jQuery.ajax({
                    url: baseUrl+"/redberry/services/mealPlan/getMealPlans",
                    method: "GET",
                    dataType: "JSON",
                    success: function (data) {
                       //
                    }
        });
    ```

- When creating a new service add CORS Filter 
    ```
    @CrossOriginResourceSharing(allowOrigins = {
            "http://redberry.com","https://redberry.com","http://www.redberry.com","https://www.redberry.com"
    })
    ```
    [jax-rs-cors] - Apache CXF CORS

   [jax-rs-cors]: <http://cxf.apache.org/docs/jax-rs-cors.html>
