//  .js for suggestions and convenience pls use mongodb Compass or shell

/*
Mongo Aggregation
Create a student collection consisting of fields like Roll No, name, class, marks, sports etc
1. Display the first 5 toppers of TE
2. Display marks of topper of each division
3. Display the average marks of each division
4. Display the rollcall of TE Comp A
5. Display Name, Class and Marks of all students
6. Display list of students who play football
---------------------------------------------------------------------
*/

db.createCollection('stud');

db.stud.insertMany(
[{
    roll:8,
    name:'Vaibhav',
    class:'TE',
    div:'B',
    marks: 95,
    sport: 'Football'
},
{
    roll:12,
    name:'Anjali',
    class:'TE',
    div:'B',
    marks: 80,
    sport: 'Cricket'
},
{
    roll:10,
    name:'Vaibhav',
    class:'TE',
    div:'B',
    marks: 90,
    sport: 'Football'
},
{
    roll:9,
    name:'Nayan',
    class:'TE',
    div:'A',
    marks: 99,
    sport: 'Cricket'
},
{
    roll:5,
    name:'Shardul',
    class:'TE',
    div:'B',
    marks: 96,
    sport: 'Football'
},
{
    roll:1,
    name:'Ankush',
    class:'TE',
    div:'A',
    marks: 55,
    sport: 'Hockey'
},
{
    roll:4,
    name:'Devesh',
    class:'TE',
    div:'A',
    marks: 75,
    sport: 'Hockey'
}]);
db.stud.insertMany(
[{
    roll:20,
    name:'Aditya',
    class:'BE',
    div:'B',
    marks: 92,
    sport: 'Football'
},
{
    roll:21,
    name:'Ash',
    class:'BE',
    div:'A',
    marks: 30,
    sport: 'Tennis'
},
{
    roll: 22,
    name:'Naina',
    class:'BE',
    div:'B',
    marks: 50,
    sport: 'Kabaddi'
},
{
    roll:23,
    name:'Anvesh',
    class:'BE',
    div:'A',
    marks: 65,
    sport: 'Chess'
},
{
    roll:24,
    name:'Sagar',
    class:'BE',
    div:'B',
    marks: 35,
    sport: 'Football'
},
{
    roll: 25,
    name:'Ankur',
    class:'BE',
    div:'A',
    marks: 38,
    sport: 'Hockey'
},
{
    roll:2,
    name:'Devesh',
    class:'TE',
    div:'A',
    marks: 85,
    sport: 'Tennis'
}]);

db.stud.insertMany(
[{
    roll:26,
    name:'Yogesh',
    class:'BE',
    div:'A',
    marks: 52,
    sport: 'Kabaddi'
},
{
    roll:27,
    name:'Parth',
    class:'BE',
    div:'A',
    marks: 68,
    sport: 'Chess'
},
{
    roll: 28,
    name:'Namrata',
    class:'BE',
    div:'B',
    marks: 98,
    sport: 'Cricket'
},
{
    roll:29,
    name:'Netra',
    class:'BE',
    div:'A',
    marks: 75,
    sport: 'Tennis'
},
{
    roll:30,
    name:'Ravindra',
    class:'BE',
    div:'A',
    marks: 25,
    sport: 'Football'
},
{
    roll: 11,
    name:'Vaibhav',
    class:'TE',
    div:'A',
    marks: 78,
    sport: 'Hockey'
},
{
    roll:3,
    name:'Yash',
    class:'TE',
    div:'A',
    marks: 25,
    sport: 'Hockey'
}]);

/*1.*/ db.stud.aggregate([{$match:{class:'TE'}},{$sort:{marks:-1}},{$limit:5}]);

/*2.*/ db.stud.aggregate([{$group:{_id:"$class",markMax:{$max:"$marks"}}}]);

/*3.*/ db.stud.aggregate([{$group:{_id:"$div",avgMarks:{$avg:"$marks"}}}]);

/*4.*/ db.stud.aggregate([{$match:{class:'TE',div:'A'}},{$group:{_id:"$div",Rollcall:{$push:"$roll"}}}]);

/*5.*/ db.stud.find({class:'TE',div:'A',marks:{$lte:40}})

/*6.*/ db.stud.aggregate([{$project:{name:1,class:1,marks:1}}]);

/*7.*/ db.stud.aggregate([{$match:{sport:'Football'}}]);