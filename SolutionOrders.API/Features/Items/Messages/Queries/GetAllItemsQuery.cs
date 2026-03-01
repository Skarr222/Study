using MediatR;
using SolutionOrders.API.Features.Items.Messages.DTOs;

namespace SolutionOrders.API.Features.Items.Queries.GetAllItems
{
    public class GetAllItemsQuery : IRequest<List<ItemDto>>
    {
        // Query bez parametrów - po prostu "daj wszystkie"
    }
}
