var example0 =
{
  "words":["hello","world"]
};
console.log("0:\t"+example0.words[0]+" "+example0.words[1]+"\n");



var example1 =
{
  "word1":"hey",
  "word2":"again"
};
console.log("1:\t"+example1.word1+" "+example1.word2+"\n");



var example2 =
{
  "yes":"no"
};
console.log("2:\t"+JSON.stringify(example2)+"\n");



var example3 =
{
  "numbers":["0","1","2"]
};//this is a js object
var numArray=[];
for(var i = 0; i < example3.numbers.length; i++)
{
  numArray.push(example3.numbers[i]);
}
console.log("3:\t"+numArray.length+" "+example3.numbers.length+"\n");



var example4 = '{"numbers":["4","5","6"]}';
var numArrayAgain = JSON.parse(example4);
console.log("4:\t"+numArrayAgain.numbers+"\n");
