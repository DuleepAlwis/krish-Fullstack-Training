const express = require('express');
const app = express();

app.get('/wait',async(req,res)=>{
    res.send('JOB done');
});

app.listen(8191);