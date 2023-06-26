// Attempt 1
// alert("This is the " + document.title.toLowerCase() + " template.");


// Attempt 2
// var pageTitle = document.title.toLowerCase();

// if (pageTitle.includes("date")) {
//  alert("This is the date template.");
// } else if (pageTitle.includes("time")) {
//  alert("This is the time template.");
// } else {
//  alert("This is a different template.");
// }


// Attempt 3
var pageUrl = window.location.href;

if (pageUrl.includes("/home/date")) {
  alert("This is the date template.");
} else if (pageUrl.includes("/home/time")) {
  alert("This is the time template.");
} else {
  alert("This is a different template.");
}
