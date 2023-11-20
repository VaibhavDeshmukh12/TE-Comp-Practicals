//  .js for suggestions and convenience pls use mongodb Compass or shell

db.createCollection('emp');

db.emp.insertMany([
{
    _id: 1,
    name:'Vaibhav',
    salary: 60000,
    dept: 'Security'
},
{
    _id: 2,
    name:'Nayan',
    salary: 40000,
    dept: 'Marketing'
},
{
    _id: 3,
    name:'Om',
    salary: 45000,
    dept: 'HR'
},
{
    _id: 4,
    name:'Pranay',
    salary: 35000,
    dept: 'Marketing'
},
{
    _id: 5,
    name:'Shardul',
    salary: 38000,
    dept: 'Sales'
},
{
    _id: 7,
    name:'Janhavi',
    salary: 50000,
    dept: 'Sales'
},
{
    _id: 8,
    name:'Nikita',
    salary: 35000,
    dept: 'Marketing'
},
]);

db.emp.insertMany([
    {
        _id:9,
        name:'Pranita',
        salary:35000,
        dept:'HR'
    },
    {
        _id:10,
        name:'smith',
        salary:40000,
        dept:'Security'
    }
]);

db.emp.find({salary:{$gt:50000}});

db.emp.find({$and:[{dept:"Marketing",salary:{$lt:45000}}]});

db.emp.createIndex({_id:1});

db.emp.find({}).sort({salary:-1}).limit(5);

db.emp.find({dept:'Marketing',salary:{$lt:45000}});

db.emp.updateOne({name:'smith'},{$inc:{salary:5000}});

db.emp.find({dept:'Marketing',salary:{$lt:45000}});

db.emp.find({}).sort({salary:-1}).limit(5);

db.emp.deleteOne({_id:4});