/**
 * Created by Aspire on 12.04.2017.
 */
var baseUrl = "/api/search";
var currentLocation = window.location.href;
var search = currentLocation.substr(currentLocation.lastIndexOf('/'));
var url = baseUrl + search;

$.ajax({
    url: url,
    type: "GET",
    beforeSend: setEtag,
    success: onResponse,
    error: onError
});



function getLastQuery() {
    return JSON.parse(localStorage.getItem('lastQuery')) || {};
}
function storeQuery(query) {
    localStorage.setItem('lastQuery', JSON.stringify(query));
}
function setEtag(xhr) {
    xhr.setRequestHeader('If-None-Match', getLastQuery().etag)
}

function onError(xhr, status, error) {
    var errorInfo = $.parseJSON(xhr.responseText);

    alert('xhr status: ' + xhr.status
        + " cause: " + errorInfo.message
        + " path: " + errorInfo.path
    );
}

function onResponse(tweets, status, xhr) {
    if (xhr.status == 304) {
        console.log('Response has not changed');
        tweets = getLastQuery().tweets
    }
    var etag = xhr.getResponseHeader('Etag');
    storeQuery({tweets: tweets, etag: etag});
    displayTweets(tweets);
}
function displayTweets(tweets) {
    $('#tweets').empty();
    $.each(tweets, function (index, tweet) {
        addTweet(tweet);
    })
}

function addTweet(tweet) {
    var template = _.template('<li class="collection-item avatar">' +
        '<img class="circle" src="${tweet.profileImageUrl}" />' +
        '<span class="title">${tweet.user}</span>' +
        '<p>${tweet.text}</p>' +
        '</li>');
    $('#tweets').append(template({tweet: tweet}));
}

