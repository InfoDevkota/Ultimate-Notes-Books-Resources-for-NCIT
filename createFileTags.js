const fs = require('fs');
const path = require('path');

const notes = [];
// noteItem = {
//     tags: [],
//     path: "",
//     title: ""
// }

/**
 * to get all files in a directory.
 * @param {string} dirPath 
 * @param {array} arrayOfFiles 
 */
const getAllFiles = function (dirPath, arrayOfFiles) {
    files = fs.readdirSync(dirPath);

    arrayOfFiles = arrayOfFiles || []
    

    files.forEach(function (file) {
        if (fs.statSync(dirPath + "/" + file).isDirectory()) {
            arrayOfFiles = getAllFiles(dirPath + "/" + file, arrayOfFiles);
        } else {
            let tags = []

            //if working on windows machine, replace / with \ (/[\s-.\]+/) [probably :) ]
            let miniTags = dirPath.split(/[/]+/); //add dir name on tag too, split on space, - , ., /
            miniTags.shift(); //remove empty string from first of dir
            tags.push(...miniTags)

            miniTags = file.split(/[.]+/); //we will tag the file object with, file name aslo split on space and -.
            // since most file contains file extension lets pop last element.
            miniTags.pop();
            tags.push(...miniTags)

            // console.log(tags);
            let noteItem = {
                tags,
                path: path.join(dirPath, "/", file),
                title: file
            }
            notes.push(noteItem)
            // tags = [];
        }
    })

    return notes
}


/**
 * start the task to get all the files and tag them
 */
const createFilesJS = () => {
    //get files
    let files = getAllFiles("./notes", []);
    // console.log(files);
    fs.writeFileSync("files.js", `const notes = ${JSON.stringify(files)};`);
    
}

createFilesJS();